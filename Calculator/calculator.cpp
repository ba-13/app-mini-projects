#include "calculator.h"
#include "ui_calculator.h"

double calcVal = 0.0;
double currVal = 0.0;
bool divTrigger = false;
bool addTrigger = false;
bool multTrigger = false;
bool subTrigger = false;
bool memShowing = false;

Calculator::Calculator(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::Calculator)
{
    ui->setupUi(this);

    ui->Display->setText(QString::number(calcVal));

    QPushButton *numButtons[10];
    for(int i=0; i<10; i++) {
        QString butName = "Button" + QString::number(i);
        numButtons[i] = Calculator::findChild<QPushButton *>(butName);
        connect(numButtons[i], SIGNAL(released()), this,
                SLOT(NumPressed()));
    }

    connect(ui->Add, SIGNAL(released()), this,
            SLOT(MathButtonPressed()));
    connect(ui->Subtract, SIGNAL(released()), this,
            SLOT(MathButtonPressed()));
    connect(ui->Multiply, SIGNAL(released()), this,
            SLOT(MathButtonPressed()));
    connect(ui->Divide, SIGNAL(released()), this,
            SLOT(MathButtonPressed()));

    connect(ui->Equals, SIGNAL(released()), this,
            SLOT(EqualButtonPressed()));
    connect(ui->Clear, SIGNAL(released()), this,
            SLOT(ClearScreen()));
    connect(ui->ChangeSign, SIGNAL(released()), this,
            SLOT(ChangeNumberSign()));
    connect(ui->MemGet, SIGNAL(released()), this,
            SLOT(MemoryShow()));
    connect(ui->MemAdd, SIGNAL(released()), this,
            SLOT(MemoryModify()));
    connect(ui->MemMinus, SIGNAL(released()), this,
            SLOT(MemoryModify()));
    connect(ui->Backspace, SIGNAL(released()), this,
            SLOT(Backspace()));
}

Calculator::~Calculator()
{
    delete ui;
}

void Calculator::NumPressed() {
    QPushButton *button = (QPushButton *)sender();
    QString butVal = button->text();
    QString displayVal = ui->Display->text();
    if(displayVal.toDouble() == 0 || displayVal.toDouble() == 0.0) {
        ui->Display->setText(butVal);
    } else {
        QString newVal = displayVal + butVal;
        double dblNewVal = newVal.toDouble();
        ui->Display->setText(QString::number(dblNewVal, 'g', 16));
    }
}

void Calculator::MathButtonPressed() {
    divTrigger = false;
    multTrigger = false;
    subTrigger = false;
    addTrigger = false;
    QString displayVal = ui->Display->text();
    calcVal = displayVal.toDouble(); // storing the first number entered.
    QPushButton *button = (QPushButton *)sender(); // sender who sent us to this function.
    QString butVal = button->text();
    if(QString::compare(butVal, "/", Qt::CaseInsensitive) == 0) {
        divTrigger = true;
    } else if(QString::compare(butVal, "*", Qt::CaseInsensitive) == 0) {
        multTrigger = true;
    } else if(QString::compare(butVal, "+", Qt::CaseInsensitive) == 0) {
        addTrigger = true;
    } else if(QString::compare(butVal, "-", Qt::CaseInsensitive) == 0) {
        subTrigger = true;
    }
    ui->Display->setText(""); // clears screen if math button is pressed.
}

void Calculator::EqualButtonPressed() {
    double solution = 0.0;
    QString displayVal = ui->Display->text();
    double dblDisplayVal = displayVal.toDouble();
    if(addTrigger || subTrigger || multTrigger || divTrigger) {
        if(addTrigger) {
            solution = calcVal + dblDisplayVal;
        } else if(subTrigger) {
            solution = calcVal - dblDisplayVal;
        } else if(multTrigger) {
            solution = calcVal * dblDisplayVal;
        } else if(divTrigger) {
            solution = calcVal / dblDisplayVal;
        }
    }
    ui->Display->setText(QString::number(solution));
}

void Calculator::ClearScreen() {
    calcVal = 0.0;
    divTrigger = false;
    multTrigger = false;
    subTrigger = false;
    addTrigger = false;
    ui->Display->setText("");
}

void Calculator::ChangeNumberSign() {
    QString displayVal = ui->Display->text();
    QRegExp reg("-?[0-9.]*");
    if(reg.exactMatch(displayVal)) {
        double dblDisplayVal = displayVal.toDouble();
        double dblDisplayValSign = -1 * dblDisplayVal;
        ui->Display->setText(QString::number(dblDisplayValSign));
    }
}

void Calculator::MemoryShow() {
    if(!memShowing) {
        currVal = ui->Display->text().toDouble();
        memShowing = true;
        ui->Display->setText(QString::number(calcVal));
    } else {
        memShowing = false;
        ui->Display->setText(QString::number(currVal));
    }
}

void Calculator::MemoryModify() {
    QPushButton *button = (QPushButton *)sender();
    QString butVal = button->text();
    QString displayVal = ui->Display->text();
    if(butVal == "M+") {
        calcVal += displayVal.toDouble();
    } else if(butVal == "M-") {
        calcVal -= displayVal.toDouble();
    }
}

void Calculator::Backspace() {
    QString displayVal = ui->Display->text();
    displayVal.chop(1);
    ui->Display->setText(displayVal);
}
