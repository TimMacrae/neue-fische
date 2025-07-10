class Product {
  constructor(name, sku, category, quantity, price, expiryDate) {
    this.name = name;
    this.sku = sku;
    this.category = category;
    this.quantity = quantity;
    this.price = price;
    this.expiryDate = expiryDate;
  }

  toString() {
    return `${this.name} (${this.sku}) - ${this.category} | Qty: ${this.quantity}, $${this.price}, Expires: ${this.expiryDate}`;
  }
}

module.exports = Product;
