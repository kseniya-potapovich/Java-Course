# Clone
Clonable - это интерфейс-маркер, который показывает JVM, что нам не разрешено использовать метод clone() (выдаст исключение CloneNotSupportedException). 
Чтобы мы смогли правильно пользоваться этим методом, мы должны переопределить метод Object.clone()