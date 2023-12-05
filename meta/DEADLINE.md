# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice looking HTML.

## Part 1: App Description

> Please provide a firendly description of your app, including the
> the primary functions available to users of the app. Be sure to
> describe exactly what APIs you are using and how they are connected
> in a meaningful way.

> **Also, include the GitHub `https` URL to your repository.**

My application offers users a straightforward interface to access
real-time stock information. With a dropdown menu for selecting
stocks and a "Go!" button to initiate the process, users can easily
get details about a chosen stock. This includes retrieving the stock's
name and last trade specifics via the Finage API, accessing data about
company peers through the Finnhub API, and getting news related to
the selected stock via the Stockdata API. This JavaFX-based user
interface presents the information neatly, utilizing labels to
display the stock's name, last trade, company peers, and news
within a scrollable area. By using Java's HttpClient, the app
makes HTTP requests to the respective APIs based on user input,
handling potential HTTP errors and ensuring informative messages
are displayed in case of any issues. Ultimately, this application
streamlines the process of obtaining vital stock-related data in a
user-friendly manner.

GitHub Link: https://github.com/vachaibar/cs1302-api-app

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

A few new thing I learned from working on this project is how to make
boxes inside another box. In my project, I was able to put the stockName
Box, the lastTrade Box, and the peers Box inside one HBox. I also learned
how to add a scroll bar to a box and make the combo box smaller to fit in
the app.

The most exciting part of this project was seeing the app being built. I
enjoyed seeing all the features on the app and working in the correct way.

## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

If I could start the project over from scratch, I would change the layout
of the app. I do like the layout now, I call it a "Sticky Notes Layout",
however, I would like for it to look more like an app. For example, I would
love to have different pages for different aspects of the app.
