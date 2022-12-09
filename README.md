# CSC Group 131: Inventory System

## Introduction:

The program manages the inventory system of a retail store. It allows the User (Employee/Manager) to login, verifies 
their identity and allows them to manipulate the items in the inventory.

## Entities:

There are four main entities and one interface. 

### 1. Employee
The employee class has 2 attributes.
* `username`
* `password`

These are private attributes with getters and setters to access them.

### 2. Item
The item class implemenets the ItemInterface class. Item has 7 attributes.

* `serialNumber`
* `name`
* `price`
* `quantity`
* `categories`
* `expirationDates`
* `storageLocation`

`serialNumber` is a string that represents the serial number. `name` is a string that represents the name of the item.
`price` is a double that represents the price of the item.
All the attributes are private and accessed through getter and setter methods. Additionally, there are methods for 
formatting the Item into a string array. Through these attributes we are able to define an Item in our inventory.

### 3. Item Interface

This class is an interface containing getters and setters along with the getArrayFormat method. This interface also has
constants for the positions of each attribute when the Item is in string array format.

### 4. TempDataStorage

TempDataStorage is the main class responsible for containing the inventory. It is implemented using the Singleton design
pattern. It has no constructor, rather a setInventory method through which the inventory is instantiated. The attributes
of TempDataStorage are as follows:

* `inventory`

`inventory` is a Map with the keys as strings representing the serial number and the value being an ItemInterface. This
allows for different types of items that implement the item interface to be put into the dictionary while following
clean architecture and solid design principles.

### 5. User

The user class has two attributes.

* `userName`
* `status`

`userName` is a string that represents the username inputted to access the program. `status` is a string that represents
whether the user is an employee or manager. 


