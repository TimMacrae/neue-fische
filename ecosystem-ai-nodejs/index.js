const readline = require("readline");
const Inventory = require("./inventory");
const Product = require("./product");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inventory = new Inventory();

function prompt(question) {
  return new Promise((resolve) => rl.question(question, resolve));
}

async function mainMenu() {
  while (true) {
    console.log("\n=== Supermarket Inventory Menu ===");
    console.log("1. Add product");
    console.log("2. View all products");
    console.log("3. Update product quantity");
    console.log("4. Delete product");
    console.log("5. Exit");

    const choice = await prompt("Choose an option: ");

    switch (choice.trim()) {
      case "1":
        try {
          const name = await prompt("Name: ");
          const sku = await prompt("SKU: ");
          const category = await prompt("Category: ");
          const quantity = parseInt(await prompt("Quantity: "), 10);
          const price = parseFloat(await prompt("Price: "));
          const expiry = await prompt("Expiry Date (YYYY-MM-DD): ");

          const product = new Product(
            name,
            sku,
            category,
            quantity,
            price,
            expiry
          );
          inventory.addProduct(product);
          console.log("✅ Product added.");
        } catch (err) {
          console.log("❌ Error:", err.message);
        }
        break;

      case "2":
        const products = inventory.listProducts();
        if (products.length === 0) {
          console.log("📦 Inventory is empty.");
        } else {
          products.forEach((p) => console.log(p.toString()));
        }
        break;

      case "3":
        try {
          const sku = await prompt("SKU: ");
          const quantity = parseInt(await prompt("New Quantity: "), 10);
          inventory.updateQuantity(sku, quantity);
          console.log("✅ Quantity updated.");
        } catch (err) {
          console.log("❌ Error:", err.message);
        }
        break;

      case "4":
        const sku = await prompt("SKU to delete: ");
        inventory.deleteProduct(sku);
        console.log("🗑️ Product deleted (if it existed).");
        break;

      case "5":
        console.log("👋 Goodbye!");
        rl.close();
        return;

      default:
        console.log("⚠️ Invalid option.");
    }
  }
}

mainMenu();
