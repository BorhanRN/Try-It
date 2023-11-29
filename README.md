# My Personal Project

##  TRY it - Experience Tracker

### Overview

The TRY it experience tracker allows
users to record, rate and describe their experiences in life.

Whether it be:
- **Rating** favourite places to eat around the city
- **Ranking** and **reviewing** favorite movies or tv shows
- **Reflecting** on courses taken throughout school
- and **many** more...

Users will be able to add and label their entry along with a rating and a description 
detailing their experience and can be updated to track changes over time. Users will also 
be provided a log of key events performed which can be used for tracking changes in their journal
and also for debugging.

### Why did I choose this project?

As someone who greatly enjoys trying new things and building new experiences,
it often gets hard keeping track of all the different things I have tried
and remembering my initial thoughts of them, especially after time passes. 

With an app like this, that is no longer an issue. Initial thoughts can be kept
for later review, new and changed opinions can be updated; and overall, 
all of life's experiences can be kept handy. Essentially it is like an interactive journal.

### User Stories

- As a user, I want to be able to add an item entry to my journal with necessary ratings and descriptions
- As a user, I want to be able to view previously made entries
- As a user, I want to be able to remove an item entry to my journal
- As a user, I want to be able to update my item entry
- As a user, I want to be able to have the option to save the entire state of the application to file
- As a user, I want to be able to load a state from file and resume where I left off

### Instructions for User

- You can generate the first required action related to adding Xs to a Y by creating a new entry and adding it to a list of existing entries
- You can generate the second required action related to adding Xs to a Y by editing, viewing, or removing entries from the existent list of entries
- You can locate my visual component in the form of a logo on start up
- You can save the state of my application by pressing the save button in the main menu
- You can reload the state of my application by pressing the load button in the main menu
- You can view a log of all the actions performed in the terminal by pressing the quit button

### Looking Forward - Changes I Would Make

- I would implement exceptions to handle unwanted user input cases
- I would likely remove the view a single frame feature because with the addition of viewing all frames it seems redundant.
Otherwise, I would refactor the feature to have new and improved functionality to make it more useful.
- One feature I would like to add is a sort by category feature that would allow users to make their
own categories and tag or group their entries as such. These tags could later be used in a search or display
feature to present only the subset of entries that contain the tag.
- Another feature I would like to add is giving each entry its own unique id number to be passed into the edit, remove and view methods.
With this addition it would be possible to refer to entries by their id number rather than by their spot in the array list.
For example, in a list with 4 entries, when one is removed from the middle the user will not have to mentally shift all other entries
over 1 index (removing entry 2 makes entry 3 become 2 and 4 become 3). Another way to do this would be to search the list of entries
by title or some other identifying feature that remains constant.