##1. Lazy Loading (Virtual Proxy)
Lazy loading is a concept where we delay the loading of object until the point where we need it.

- Lazy loading is just a fancy name given to the process of initializing a class when it’s actually needed.

- In simple words, Lazy loading is a software design pattern where the initialization of an object occurs only when it is actually needed and not before to preserve simplicity of usage and improve performance.

- Lazy loading is essential when the cost of object creation is very high and the use of the object is very rare. So this is the scenario where it’s worth implementing lazy loading.The fundamental idea of lazy loading is to load object/data when needed.

##2. Lazy Initialization
The Lazy Initialization technique consists of checking the value of a class field when it’s being used. If that value equals to null then that field gets loaded with the proper value before it is returned.


##3. View Holder
Basically, A value holder is a generic object that handles the lazy loading behavior and appears in place of the object’s data fields.When the user needs to access it, they simply ask the value holder for its value by calling the GetValue method. At that time (and only then), the value gets loaded from a database or from a service.(this is not always needed).




https://www.geeksforgeeks.org/lazy-loading-design-pattern/