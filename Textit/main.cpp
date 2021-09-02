#include "mainwindow.h"
#include <QApplication> // Handle widget, event handling, mouse movements.

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    w.show();

    return a.exec(); // Puts application in a loop.
}
