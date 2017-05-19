package io.github.maboueita.architecturecomponentssample.data;


import java.util.List;

public class OverviewApiResponse {

    private String status;
    private String copyright;
    private int numOfResults;
    private Results results;

    public int getNumOfResults() {
        return numOfResults;
    }

    public void setNumOfResults(int numOfResults) {
        this.numOfResults = numOfResults;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }


    class Results {

        private String bestSellersDate;
        private String publishedDateDescription;
        private List<Lists> lists;

        public String getBestSellersDate() {
            return bestSellersDate;
        }

        public void setBestSellersDate(String bestSellersDate) {
            this.bestSellersDate = bestSellersDate;
        }

        public String getPublishedDateDescription() {
            return publishedDateDescription;
        }

        public void setPublishedDateDescription(String publishedDateDescription) {
            this.publishedDateDescription = publishedDateDescription;
        }

        public List<Lists> getLists() {
            return lists;
        }

        public void setLists(List<Lists> lists) {
            this.lists = lists;
        }

        class Lists {

            private int listId;
            private String listName;
            private List<Book> books;

            public int getListId() {
                return listId;
            }

            public void setListId(int listId) {
                this.listId = listId;
            }

            public String getListName() {
                return listName;
            }

            public void setListName(String listName) {
                this.listName = listName;
            }

            public List<Book> getBooks() {
                return books;
            }

            public void setBooks(List<Book> books) {
                this.books = books;
            }

            class Book {

                private String author;
                private String title;
                private String description;

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }


        }


    }


}
