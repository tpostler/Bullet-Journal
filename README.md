# 3500 PA05 Project Repo

Created by Alyssa Barra, Hala Gilbett, and Tori Postler


[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

![Gui Implementation of one of our themes for our Sunday upload] 
([/assets/GuiDesignForSunday.png](https://github.com/CS-3500-OOD/pa05-fotenotfanclub/blob/71992457bce1227765512ed649aa3741fa6b7603/src/main/resources/GuiDesignForSunday.png))

Introducing Eventa, the ultimate app for event and task management. Stay organized and on top of your commitments effortlessly.
With Eventa, you can easily create and manage events and tasks, ensuring you never miss an important deadline. The app provides a comprehensive Week View, giving you a clear overview of your schedule at a glance.
Tasks and events also support a mini view feature allowing you to expand any task of event with a click of a button. Stay productive with the Task Queue feature, 
allowing you to prioritize and organize your tasks efficiently. The Menu Bar and Shortcuts provide quick access to essential features, saving you time and effort.
Customize the app's appearance with Themes, choosing from a range of visually appealing options. Personalize your experience and make Eventa truly yours.
Take essential notes and set goals with the built-in Notes and Goals feature. Stay focused and motivated by keeping all your essential information in one place.
Search for specific tasks easily with the Task Search function. Attach links to events and tasks to keep all relevant information accessible.
Enjoy the Flourish animation for a delightful experience. Add a Privacy Lock for enhanced security, and enjoy our lovely branded Splash screen for your viewing pleasure.
Simplify your event and task management with Eventa. Download now and take control of your schedule with ease!


- S - The Model package contains separate classes for handling different aspects of the application, such as bulletJournal.model.PasswordJson for password-related functionality and bulletJournal.model.JsonUtils for JSON serialization and deserialization.
The Controller package contains classes responsible for specific tasks, such as SetupController for password setup and Event and Task Controller for managing tasks and events. 
- O - The Model package contains classes for representing different entities in the application, such as Note and Goal. These classes are designed to be easily extendable, allowing for the addition of new entity types without modifying the existing code. For example, if a new entity type, such as Task, needs to be introduced, a new class can be created without modifying the existing codebase.
- L - ControllerAbstract objects with their subclasses, such as ControllerTheme. This subclass inherits the common interface and behavior defined in the ControllerAbstract class, ensuring that they can be used interchangeably without modifying the existing codebase.
- I - The ControllerInterface interface defines only the methods required for controlling the application. Each controller class, such as SetupController and SettingsController, implements this interface and provides its own implementation of the necessary methods without being forced to implement unnecessary methods.
- D - The SetupController, SettingController, TaskController, EventController, WelcomeController class depends on the abstraction defined by the ControllerInterface interface. This allows the controller to work with any interface implementation, promoting loose coupling and enabling easier swapping of dependencies.

To begin, we would enhance the data model in the repository to support event and task categorization. This entails adding a new property, such as a category, to the existing Event and Task classes. The category property would hold the category information for each event or task.

Next, we would modify the GUI to enable users to create new categories and assign them to events and tasks. This may involve incorporating new input fields or dialog boxes where users can enter the category details during event or task creation.

To manage the categories effectively, we would implement a CategoryManager class that handles the creation, deletion, and retrieval of categories. This class would maintain a collection of categories and provide methods to add, remove, and retrieve categories as needed.

During the event and task creation process, we would update the GUI to include the category assignment functionality. Users would be able to select or enter the appropriate category for each event or task. The selected category would then be associated with the event or task and stored in the data model.

When it comes to persistence, we would update the saving and loading mechanisms to include the category information. When saving a week, the assigned categories for events and tasks would be serialized and saved along with other data. Similarly, when loading a week, the category information would be deserialized and assigned to the respective events and tasks.

To provide a visually appealing user interface, we could enhance the presentation by displaying the assigned categories for events and tasks. This could be achieved by adding labels or icons indicating the category next to each event or task in the week view, allowing users to easily identify and organize their schedules based on the assigned categories.

By following these steps and incorporating the necessary modifications into our existing codebase, we would successfully extend the program to include the feature of categorizing events and tasks. Users would be able to create new categories, assign them to events and tasks, and visualize the categories in the user interface. This enhancement would provide improved organization and categorization, enabling users to effectively manage and navigate their schedules.

