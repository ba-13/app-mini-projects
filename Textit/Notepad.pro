QT       += core gui printsupport

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++11

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
    main.cpp \
    mainwindow.cpp

HEADERS += \
    mainwindow.h

FORMS += \
    mainwindow.ui

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

RESOURCES += \
    Resources.qrc

DISTFILES += \
    C:/Users/bansh/Pictures/icons/Copy.bmp \
    C:/Users/bansh/Pictures/icons/Cut.bmp \
    C:/Users/bansh/Pictures/icons/New.bmp \
    C:/Users/bansh/Pictures/icons/Open.bmp \
    C:/Users/bansh/Pictures/icons/Paste.bmp \
    C:/Users/bansh/Pictures/icons/Save.bmp
