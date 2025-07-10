class Inventory {
  constructor() {
    this.products = new Map();
  }

  addProduct(product) {
    if (this.products.has(product.sku)) {
      throw new Error(`Product with SKU ${product.sku} already exists.`);
    }
    this.products.set(product.sku, product);
  }

  getProduct(sku) {
    return this.products.get(sku);
  }

  listProducts() {
    return Array.from(this.products.values());
  }

  updateQuantity(sku, quantity) {
    const product = this.getProduct(sku);
    if (!product) throw new Error("Product not found.");
    product.quantity = quantity;
  }

  deleteProduct(sku) {
    this.products.delete(sku);
  }
}

module.exports = Inventory;
