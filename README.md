API-Library-JAVA-Spring-PostgreSql
=================

## Jeux de donnée

Book :

    Méthode GET
    /apiBook/findAllBooks
    Méthode GET
    /apiBook/findOneBook?id=1
    Méthode POST
    /apiBook/addBook
    {
    "title": "testBookA",
    "summary": "loreIpsum",
    "category":
        {
            "idCategory": 1,
            "nameCategory": "Aventure"
        },
        "author":
        {
            "idAuthor": 1,
        "nameAuthor": "Musso",
            "firstnameAuthor": "Guillaume"
        }
    }
    Méthode DELETE
    /apiBook/deleteBook
    {
        "idBook": 1,
        "title": "testBookA",
        "summary": "loreIpsum"
    }
    Méthode DELETE
    /apiBook/deleteBookById?id=1


Categorie :

    GET
    /apiCategory/findAllCategories
    GET
    /apiAuthor/findOneCategory?id=1
    POST
    /apiCategory/addCategory
    {
        "name": "Aventure"
    }
    PUT
    /apiCategory/updateCategory
    {
        "idCategory": 1,
        "nameCategory": "AventureTest"
    }
    DELETE
    /apiCategory/deleteCategory
    {
        "idCategory": 1,
        "nameCategory": "Aventure"
    }
    DELETE
    /apiCategory/deleteCategoryById?id=1
    
Auteur

    GET
    /apiAuthor/findAllAuthors
    GET
    /apiAuthor/findOneAuthor?id=1
    POST
    /apiAuthor/addAuthor
    {
        "nameAuthor": "Musso",
        "firstnameAuthor": "Guillaume"
    }
    PUT
    /apiAuthor/updateAuthor
    {
        "idAuthor": 1,
        "nameAuthor": "MussoTest",
        "firstnameAuthor": "GuillaumeTest"
    }
    DELETE
    /apiAuthor/deleteAuthor
    {
        "idAuthor": 1,
        "nameAuthor": "Musso",
        "firstnameAuthor": "Guillaume"
    }
    DELETE
    /apiAuthor/deleteAuthorById?id=1