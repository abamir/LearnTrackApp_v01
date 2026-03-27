# Design Notes

## Why ArrayList Instead of Array?
Arrays have a fixed size decided at creation time. Since we don't know
how many students or courses will be added at runtime, ArrayList was the right
choice — it resizes dynamically and provides add/remove operations out of the box.

## Where Static Members Were Used and Why
`IdGenerator` uses static counter fields (`studentIdCounter`, etc.) because
the counter must be shared across all service instances — it is class-level
state, not object-level state. Static methods were used to expose them without
needing an instance.

## Where Inheritance Was Used and What Was Gained
`Student` extends `Person`. This removed duplication of id/firstName/lastName/email
fields. The `getDisplayName()` method was defined in `Person` and overridden in
`Student` to include batch info — demonstrating polymorphism. Adding a `Trainer`
class later would be trivial since it would also extend `Person`.