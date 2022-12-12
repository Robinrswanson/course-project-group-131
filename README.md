# CSC Group 131: Inventory System

## Introduction:

The program manages the inventory system of a retail store. It allows the User (Employee/Manager) to login, verifies
their identity and allows them to manipulate the items in the inventory.

## Entities:

There are three main entities and one interface.

### 1. Item
The item class implements the ItemInterface class. Item has 7 attributes.

* `serialNumber`
* `name`
* `price`
* `quantity`
* `categories`
* `expirationDates`
* `storageLocation`

`serialNumber` is a string that represents the serial number. `name` is a string that represents the name of the item.
`price` is a double that represents the price of the item. `quantity` is an int that represents the quantity. `categories` is a List<String> that represents the categories of the item. `expirationDates` is a Date that represents the expiration date of the item if applicable. `storageLocation` is a string that represents where the item is in storage.
All the attributes are private and accessed through getter and setter methods. Additionally, there are methods for
formatting the Item into a string array. Through these attributes we are able to define an Item in our inventory.

### 2. Item Interface

This class is an interface containing getters and setters along with the getArrayFormat method. This interface also has
constants for the positions of each attribute when the Item is in string array format.

### 3. TempDataStorage

TempDataStorage is the main class responsible for containing the inventory. It is implemented using the Singleton design
pattern. It has no constructor, rather a setInventory method through which the inventory is instantiated. The attributes
of TempDataStorage are as follows:

* `inventory`

`inventory` is a Map with the keys as strings representing the serial number and the value being an ItemInterface. This
allows for different types of items that implement the item interface to be put into the dictionary while following
clean architecture and solid design principles.

### 4. User

The user class has two attributes.

* `userName`
* `status`

`userName` is a string that represents the username inputted to access the program. `status` is a string that represents
whether the user is an employee or manager.

## Features

### 1. Log In

Through the `LoginScreen` the user inputs a username and password. The screen activates the `LoginController` which activates the `Login` use case interactor while passing in an instance of the `GatewayReaderInterface` that is created using the `GatewayReader` constructor. This will check `UserName password.csv` via the `GatewayReader` which will check if the username and password provided is valid. If it is valid, the use case interactor will create an instance of `User` and tell the `LoginPresenter` to prepare success. Otherwise, prepare failure will be called.

### 2. View Sales Report

The user inputs two date strings on the `SalesReporterScreen` and clicks the “Generate Report” button which calls the `SalesReporterController`.
The `SalesReporterController` create `GatewayReader` as an instance of `GatewayReaderInterface` to read from an `history.csv` packaging the data along with the 2 date strings to `SalesReporterInputData` which also performs the calculations. `SalesReporter` calls input data class and formats into ArrayList<String[]>, calls `SalesReporterPresenter` through an interface
which calls the `SalesReporterScreen` through an interface and updates to show the sales report.

### 3. Update the Price of an Item

Through the `UpdateScreen` the user inputs a serial number and price. The screen activates the `UpdateController` which activates the `UpdatePrice` use case interactor. The interactor will first check the `status` attribute of the `User` to see if the user is allowed to make such changes to the price of an item. If deemed invalid, the interactor will tell the `UpdatePresenter` to prepare failure. Otherwise, the interactor will go through the `TempDataStorage` to find the item with the same serial number. When the item is found, the interactor will call the getter method for the item’s price and change it. Then the interactor will tell the `UpdatePresenter` to prepare success to which it will display the price has been successfully updated.

### 4. Import and Export the Inventory

For importing an item, the user will input a directory of a csv file and then click the import button. This will activate the `ImportController` via the `ImportScreen`. The controller will create an instance of `GatewayReader` and classify it as a `GatewayReaderInterface`. This will be passed through the importDatabase method of `Import`. The use case interactor will go through the extracted data and add the quantities to the `TempDataStorage`. When the interactor is done adding the items, the `ImportPresenter` will be called to prepare success and tell the `ImportScreen` to display that the inventory has been successfully imported.

For exporting an item, the user will click the export button which will activate the `ExportController` through the `ExportScreen`. This will then create a `GatewayWriter` class represented as a `GatewayWriterInterface`. This is passed into the `Export` use case interactor which goes through the inventory in `TempDataStorage` and writes it to the `Database.csv` file. Finally, the `ExportPresenter` is called to prepare success which tells the `ExportScreen` to display the file path to the database.

### 5. Search

To search for an item, the user will input a serial number which will be passed to `SearchController` via the `SearchScreen`. The controller will then call the `Search` use case interactor which will search `TempDataStorage` for the item with the same serial number. If the item is found the `SearchPresenter` will be called to tell the `SearchScreen` to display the found item.
To search for an item by category, the user will input categories which will be passed to `SearchCategoryController` via the `SearchCategoryScreen`. The controller will then call the `SearchCategory` use case interactor which will search `TempDataStorage` for the item with the same categories. If the item is found the `SearchCategoryPresenter` will be called to tell the `SearchCateogryScreen` to display the found item.

### 6. View the Inventory’s History

To view the history, the user will input two strings in the format of dates. This will be passed to the `ShowHistoryController` via the `ShowHistoryScreen`. This will be passed onto the `ShowHistoryInteractor`along with an instance of `GatewayReader` that is passed in as an instance of `ShowHistoryDSGateway`. This will read the `history.csv` file and return the history data. By analyzing the data the interactor will filter out the dates not between the inputted dates and give this to the `HistoryPresenter` as an instance of `ShowHistoryResponseModel`. This is then relayed to the screen and displayed to the user.

### 7. Change the Quantity of the Item

To add to the quantity of an item, the user will input the desired quantity of items to be added along with its serial number in the `AddScreen`. The screen calls the `AddController` which will call the `AddUseCase`. The interactor will go through `TempDataStorage` to search for items with the same serial number and add the input quantity to the original item quantity. Once finished this will call the `AddPresenter` to tell the `AddScreen` to display the success message.

To remove a quantity of an item, the user will input the desired lowered quantity of items to be removed along with its serial number in the `RemoveScreen`. The screen calls the `RemoveController` which will call the `RemoveUseCase`. The interactor will go through `TempDataStorage` to search for items with the same serial number and subtract the input quantity to the original item quantity. Once finished this will call the `RemovePresenter` to tell the `RemoveScreen` to display the success message.

To return an item, the user will input the desired quantity of items to be returned along with its serial number in the `ReturnScreen`. The screen calls the `ReturnController` which will call the `ReturnUseCase`. The interactor will go through `TempDataStorage` to search for items with the same serial number and add the input quantity to the original item quantity. Once finished this will call the `ReturnPresenter` to tell the `ReturnScreen` to display the success message.

## Main

In `Main` first the login system is initialized. Following a successful login the `MainEmployeeScreen` is created and the `InitalizeInventoryController` is called to populate `TempDataStorage`. Then a builder design pattern is employed to build all the screens for the features and the application prerequisites are set up before the screen is displayed. 

## (UPDATED) Test Coverage

In the use case layer, tests were included for every implemented use case interactor (1:1 test suite: use case ratio). A more detailed description of what each test covers is contained in a txt file for the test module in our repository. 

In the interface adaptors layer, tests were included for the gateway reader and writer, as well as additional classes for the `ShowHistory` use case. 

### Untested Parts:

The frameworks and drivers layer(screens) was not tested, nor were the controllers and presenters for each use case. Our reasoning is as follows:

1) It is impractical/very difficult to test for screen layout via JUnit Tests. The positioning of buttons, the presence or absence of necessary labels, and other features are much easier tested directly through visualization (observing what the screen looks like). Since the screens appear the same each time and do not vary significantly with differing user input, relying on eye testing is sufficient. 

2) The controllers that we implemented for each use case only had two responsibilities: one, to create the input data structures necessary for the corresponding use case interactor, and two, to call the use case interactor. The code in each controller was very limited, and testing it would merely involve testing the getters/setters of the input data to ensure it was created properly by the controller. Given the limited usefulness of tests for controllers, they were omitted.

3) Similar to controllers, our presenters had relatively little code, with their responsibility being formatting the data provided by the use case and sending it to the screen for display. As long as the use case interactor called on the correct presenter method (either `prepareSuccess()` or `prepareFailure()` in most cases), the odds for error were very unlikely. In the tests themselves, the methods for the presenters were overridden with test methods asserting true/false directly for the instance variables in the `OutputData` classes. This allowed for the testing of specific data rather than a generalized string, which ultimately proved to be more useful. 
