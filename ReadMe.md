# Stay Updated

## Overview

Concept of this application is to provide latest news updates along with providing the ability for user to store their favorite articles 
in database along with options to update the articles or add notes in the article that have been added to favorites by the user providing 
users ability to change font sizes, number of articles along with deleting favorites table.

## Prerequisites

- Android studio
- Android emulator/android phone(with enabled developer option)

## Detailed Information

- User is presented with many different news articles obtained from the API (New York Times) which can be firther accesed by clciking on any article
  for detailed information and website view of the article as presented in the images below.

<img src="https://user-images.githubusercontent.com/72910540/114471118-11d20480-9bbe-11eb-971b-b4db5fadaaa6.png" height="400" width="200"/> <img src="https://user-images.githubusercontent.com/72910540/114471840-3e3a5080-9bbf-11eb-88f8-8fabe2fcda2b.png" height="400" width="200"/>

- User can long click on any of the articles they read with heading to save it to favorites and the article will be added to database which can be accessed from
  Favorites section of the application.
- User also has the liberty to add notes to the articles body for adding notes about that particular atricular by clicking on the edit button in each article.

<img src="https://user-images.githubusercontent.com/72910540/114471754-219e1880-9bbf-11eb-8681-b3c3e2182586.png" height="400" width="200"/> <img src="https://user-images.githubusercontent.com/72910540/114472838-0d5b1b00-9bc1-11eb-98a1-d93ab8826b2c.png" height="400" width="200"/>

- User also has the option to select the font size along with putting limitation on the number of articles to be displayed on the screen.
- User also has the option to delete the complete favorite tables.
- NOTE - Once table is cleared and deleted, Please note to unselect the button to continue editing the article from the saved articles.
<img src="https://user-images.githubusercontent.com/72910540/114471838-3e3a5080-9bbf-11eb-9af8-c4207fe5a3c7.png" height="400" width="200"/>

- User can also directly contact me by clicking on the Image Buttons on the screen with their respective functions.
<img src="https://user-images.githubusercontent.com/72910540/114471832-3d092380-9bbf-11eb-9438-25bc36fd12d4.png" height="400" width="200"/>

- User can also access the credits screen where I have added the credit for the images used in te project.
<img src="https://user-images.githubusercontent.com/72910540/114471836-3e3a5080-9bbf-11eb-8c14-8cbc1993002b.png" height="400" width="200"/>



## Guide for Application

- User is presented with all the latest news with default settings of font size and number of article.
- User can click on any article to be switch to display/details page where they can read more about the news with visiting actual news article from the application
- User can also long click on particular article to save it to favorites section from the news articles page.
- User can view and edit their notes in the favorite section beneith the article and save it for later reading.
- User can then access the contacts page for contacting the developer with actual details.
- User can also change the font size along with number of articles in the news page by visiting news page and then clicking on the top right corner 
  to access setting menu for changing font size, number of articles and deleting the favorite table. 
  
## Database Schema

| TABLENAME |
| ------------- |
| ID |
| NAME |
| DESCRIPTION |
| IMAGE |
