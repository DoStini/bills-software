# Billing Software
This project was made with java using javaFX framework.
It was used to help out a small institution in a summer fair, to calculate and print bills. 

## Instalation
I'll keep updated executables updated in master branch.

 1. Download executable folder
 2. Execute Printer chooser to setup the printer. Using a POS Printer is ideal, but works with any kind.
 3. Execute faturacao to initialize the software.

## Editing the items
There is no graphical way to edit the shop.
 1. Open the executable folder
 2. Open Resources/DB.txt
The file looks like this

```
btnID//The thing//Price

btnBar//Elemento 1//1.0
btnBar_0//Elemento 2//1.0
btnBar_1//NULL//0.0
...
btnSnack//Snack//1.0
btnSnack_0//Snack 2//3.0
```
In order to change something, just modify the name to the thing you want and change the price

## Usage
 
 - If the program crashes, it autosaves the current day's earnings.
 - If the printer doesn't print anything, you can access your last bill to re-check or to print again.
 - When you end your day, press "End day" button to print out everything and save a file containing information about the ammout of sold items.

## Warnings
This software doesn't do any taxes and legislation
## License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
