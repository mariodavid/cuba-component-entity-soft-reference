# CUBA Platform Component - Soft References for Entities

This application component can be used for referencing entities without a foreign key in the database.

### What is a soft reference?

A soft reference is a reference in the data model, which does not create a foreign key in the database as well as not creating referential integritry for it.
Instead it is just a "weak" or "soft" reference to another entity.

Example:

Let's take the Customer <>--> Order example. A customer can have mutiple orders. We model that as an composition in CUBA.
This means, that there will be a column "customer_id" in the Order table, which stores the primary key of the customer in
the Order Table. For every Order, there is a Customer associated to it.

In the soft reference example, it will be different. There will be a "customer_id" column as well in the Order table. But instead
there will be no foreign key association on the database. Instead the following String will be stored in this soft reference column:
`example$Customer-2fdc4906-fa89-11e7-8c3f-9a214cf093ae`.


### Foreign keys are valuable, why would someone not want to have them?

Correct. For pretty much every case, there is no need to use soft references. Since it misses all the cool features of
referencial integrity, there are a lot of downsides. Why do we still need them? Here is an example:

Let's assume we want to have a column called "Comment". Comments can be created for a lot of different entities. There can be comments
for customers as well as comments for orders, products etc. The common way to handle that in a programming language like Java is
that you would create an interface called `Commentable`. This interface marks all classes that want to be commentable as such.
Then the Comment class could have a reference to a Commentable object. This is what polymorphism is all about.

However - there is no native equivalent in a relational database. The reason is that when you want to create a foreign key,
you need to point it to a destination table. But there is no generic table that you could point to. Instead, you want to point
to totally different tables.

For cross cutting functionality, these soft references can be the solution here.


