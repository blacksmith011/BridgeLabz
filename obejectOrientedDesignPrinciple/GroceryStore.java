//Class Diagram
+------------------+             +------------------+
|    Customer      |◆------------|     Product      |
+------------------+ 1..*        +------------------+
| - name: String   | Composition | - productName    |
| - id: int        |             | - quantity: int  |
+------------------+             | - pricePerUnit   |
| +getProducts()   |             +------------------+
| +addProduct()    |             | +getCost()       |
+------------------+             +------------------+

              |
              | uses
              v
+---------------------------+
|      BillGenerator        |
+---------------------------+
| +generateBill(Customer)   |
+---------------------------+
//Object Diagram


Customer: Alice
+------------------+
| name = "Alice"   |
| id = 201         |
+------------------+
| Products         |
+------------------+

Product1: Apples
+---------------------------+
| productName = "Apples"    |
| quantity = 2 kg           |
| pricePerUnit = $3/kg      |
| Total = $6                |
+---------------------------+

Product2: Milk
+---------------------------+
| productName = "Milk"      |
| quantity = 1 liter        |
| pricePerUnit = $2/liter   |
| Total = $2                |
+---------------------------+

Total Bill = $8
//Sequence Diagram
Customer (Alice)         BillGenerator
       |                        |
       |---- checkout() -------->|
       |                        |
       |---- getProducts() ----->|
       |                        |
       |<--- return products ----|
       |                        |
       |---- generateBill() ---->|
       |                        |
       |<--- totalBill($8) ------|
       |                        |
       |---- displayBill() ----->|
