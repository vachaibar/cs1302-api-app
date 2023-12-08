# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice looking HTML.

## Part 1.1: App Description

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

## Part 1.2: APIs

> For each RESTful JSON API that your app uses (at least two are required),
> include an example URL for a typical request made by your app. If you
> need to include additional notes (e.g., regarding API keys or rate
> limits), then you can do that below the URL/URI. Placeholders for this
> information are provided below. If your app uses more than two RESTful
> JSON APIs, then include them with similar formatting.

### API 1

```
https://api.finage.co.uk/last/stock/ + stock + ?apikey= + API_KEY
```

> Used to get last trade information.
> Api Key: API_KEYa7FAUEDJ1OS3EAWT5FY7TP8LSTX782YV
> Api Requests: 1000 API requests per month. (488/1000)

### API 2

```
https://finnhub.io/api/v1/stock/peers?symbol= + stock + &token= + API_KEY
```

> Used to get peer companies.
> Api Key: clj21tpr01qsgccbq250clj21tpr01qsgccbq25g
> Api Requests: 60 API calls per minute.

### API 3

```
https://api.stockdata.org/v1/news/all?symbols= + stock + &filter_entities=true&language=en&api_token= + API_KEY + &limit=2
```

> Used to get news.
> Api Key: oksHB7EmpVxb6HjkYxHNgltSoQDAECZLjg3chS96
> Api Requests: 100 API calls per day.

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
