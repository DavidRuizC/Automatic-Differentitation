
# 🔢 Automatic Differentiation in Java using Dual Numbers

This project implements a **forward-mode automatic differentiation system** using **dual numbers**, enabling the simultaneous computation of a function and its derivative. It is built with a modular, expression-tree-based design in Java.

> **Collaborators**: Nicolás Romeu García and Marc Roig Oliva

## 🚀 Features

- **Automatic differentiation**: Uses dual numbers to calculate both function values and derivatives.
- **Expression Trees**: Compose mathematical expressions from reusable building blocks (`Add`, `Multiply`, `Sin`, etc.).
- **Gradient-based optimization**: Performs simple gradient ascent/descent to locate local extrema.
- **Finite difference validation**: Compares autodiff results against numerical approximation.

## 🧩 Main Components

### 💡 Core Logic

- `DualNumber`: Represents a number of the form `u + εu'` where `u` is the function value and `u'` is the derivative.
- `Expression` interface: Any function (or subexpression) that can be evaluated with a `DualNumber`.

### 🔧 Operators & Functions

All expressions implement the `Expression` interface. Examples include:

- Binary Operators (extend `BinaryOperator`):
  - `Add`, `Substract`, `Multiply`, `Divide`, `Pow`
- Unary Functions:
  - `Sin`, `Cos`, `Log`
- Terminals:
  - `X`: Variable
  - `Constant`: Fixed number

Each expression correctly propagates derivative information when evaluated.

## 📄 Example Usage

In `Main.java`, we build the function:

```java
f(x) = x * (sin(x) + cos(x))
```

Then we evaluate both the value and derivative at a point:

```java
DualNumber res = expr.evaluate(new DualNumber(10, 1.0));
```

Sample output:

```
real
f(10.0) = -5.440211108893697
f'(10.0) = -7.253796278360437

Calculated
f(10.0) = -5.440211108893697
f'(10.0) = -7.253796278360437
```

## 🧪 Derivative Comparison

We compare autodiff against **finite difference** approximations with decreasing epsilon values to observe accuracy and numerical stability.

## 📈 Local Optimization

Using gradient ascent/descent:
```java
x_next = x ± h * f'(x)
```
we iteratively locate local maxima and minima of the function.

## 📦 Project Structure

- `Main.java`: Runs the test expression and prints results
- `DualNumber.java`: Core of the dual number arithmetic
- Expression classes:
  - `Add`, `Substract`, `Multiply`, `Divide`, `Pow`
  - `Sin`, `Cos`, `Log`, `Constant`, `X`

## 🔍 How to Run

1. Compile all `.java` files:
```bash
javac *.java
```

2. Run the main program:
```bash
java Main
```

You’ll see both real and autodiff results, along with extrema estimation and finite difference outputs.

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
