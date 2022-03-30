# Health Tracker Project

## About this project and Who Will Use It?:

My project is a Meal tracker that allows users to log:

- What they had for their **meals** (breakfast, lunch, dinner and snacks)
every day of the week from **Monday to Sunday**.
- How many **servings** they had of a certain food

This application can help users stick to their personal goals and motivate them to achieve those goals. 
It allows users to see visually the changes in their diet and the improvements in their lifestyles, 
which can help keep themselves accountable. Therefore, this application can be used by 
anyone who is wanting to keep track of their diet and is working towards a certain health goal. 

## Why is this project of interest to me?

Due to the pandemic, I have felt that health has become an even more relevant topic than before.
Recently, I have been setting health goals myself, which is why I am interested in creating a tracker that can allow 
users to track their meals consumed throughout the week to help them make better food choices.
I believe having a tracker that lets you see how you have been taking care
of yourself can benefit many people and help them achieve a healthier lifestyle. 

## User Stories

- As a user I want to be able to add a food item (with how many servings) to a meal of a certain day
- As a user I want to be able to view the food items on for all meals of the week 
- As a user I want to be able to view what I had for a meal on a certain day
- As a user I want to be able to delete a food item from a meal 
- As a user I want to be able to change the servings I had of a food
- As a user I want to be able to save my meals of the week to file
- As a user I want to be able to load my meals of the week from file

#Phase 4: Task 2
bread was added to breakfast of Monday's log

Egg sandwich was added to lunch of Monday's log

steak was added to dinner of Monday's log

Egg sandwich was removed from lunch of Monday's log

#Phase 4: Task 3

If I had more time with the project I would probably do some refactoring to reduce duplication. I would:

- make Tool Menu a normal class that extends Jframe and make AddMealTool, DeleteFoodTool, EditServingsTool and 
ViewMealTool each have a field of type Tool Menu. The ToolMenu class would have the panels with the jradio buttons for 
days and meal type, and the classes with the field of type ToolMenu can then add their own functionality to their ToolMenu 
field
- make an interface named Tool that implements ActionListener, and make AddMealTool, DeleteFoodTool, EditServingsTool 
and ViewMealTool implement Tool. The Tool interface would have the method constructPanel that the 4 classes have to implement
to construct panels specific to their functionality. The tool interface would also have a field of type MealTracker