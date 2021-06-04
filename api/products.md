# MK1-Shop API

##Info

Product Endpoint 

### Reference

Get: products/all

Returns an array of products from the database


``[{"id": 8a98dfua8,
"name": "Apple Macbook",
"description": "cool computer",
"price": 10.00,
"image", "https://google.com/logo"
},{"id": 8a98dfua8,
"name": "Apple Macbook",
"description": "cool computer",
"price": 10.00,
"image", "https://google.com/logo"
}]``


Post: products/add

Accepts a json object to create a task

``{
"name": "Apple Macbook",
"description": "cool computer",
"price": 10.00,
"image", "https://google.com/logo"
}``

Get: products/?id=603ee271cc24c10cc69a8122

returns task by id

``{
"id": 8a98dfua8,
"name": "Apple Macbook",
"description": "cool computer",
"price": 10.00,
"image", "https://google.com/logo"
}``

Post: products/update

Accepts a json object to update a task

``{
"id": 8a98dfua8,
"name": "Apple Macbook",
"description": "cool computer",
"price": 10.00,
"image", "https://google.com/logo"
}``

Delete: products/delete/{id}

Accepts an id integer to delete a task

``{
"id": "603ee429a300d741ff6550eb"
}``
