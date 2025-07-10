const Inventory = require("../inventory");
const Product = require("../product");

describe("Inventory Management", () => {
  let inventory;

  beforeEach(() => {
    inventory = new Inventory();
  });

  test("should add a product", () => {
    const product = new Product(
      "Milk",
      "SKU001",
      "Dairy",
      10,
      2.5,
      "2025-01-01"
    );
    inventory.addProduct(product);
    expect(inventory.getProduct("SKU001")).toBe(product);
  });

  test("should throw error when adding a product with duplicate SKU", () => {
    const product1 = new Product(
      "Milk",
      "SKU001",
      "Dairy",
      10,
      2.5,
      "2025-01-01"
    );
    const product2 = new Product(
      "Butter",
      "SKU001",
      "Dairy",
      5,
      3.0,
      "2025-02-01"
    );
    inventory.addProduct(product1);
    expect(() => inventory.addProduct(product2)).toThrow("already exists");
  });

  test("should list all products", () => {
    const product = new Product(
      "Bread",
      "SKU002",
      "Bakery",
      5,
      1.5,
      "2025-03-01"
    );
    inventory.addProduct(product);
    const products = inventory.listProducts();
    expect(products.length).toBe(1);
    expect(products[0].name).toBe("Bread");
  });

  test("should update product quantity", () => {
    const product = new Product(
      "Eggs",
      "SKU003",
      "Grocery",
      12,
      0.5,
      "2025-04-01"
    );
    inventory.addProduct(product);
    inventory.updateQuantity("SKU003", 20);
    expect(inventory.getProduct("SKU003").quantity).toBe(20);
  });

  test("should throw error when updating quantity of unknown SKU", () => {
    expect(() => inventory.updateQuantity("SKU999", 10)).toThrow(
      "Product not found"
    );
  });

  test("should delete a product", () => {
    const product = new Product(
      "Juice",
      "SKU004",
      "Beverages",
      8,
      1.75,
      "2025-05-15"
    );
    inventory.addProduct(product);
    inventory.deleteProduct("SKU004");
    expect(inventory.getProduct("SKU004")).toBeUndefined();
  });
});
