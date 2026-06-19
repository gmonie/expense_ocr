import { Expense } from "@/types/expense";

interface Props {
  expenses: Expense[];
}

export default function ExpenseTable({ expenses }: Props) {
  return (
    <table border={1} cellPadding={10}>
      <thead>
        <tr>
          <th>Store</th>
          <th>Amount</th>
          <th>Date</th>
          <th>Category</th>
        </tr>
      </thead>

      <tbody>
        {expenses.map((expense) => (
          <tr key={expense.id}>
            <td>{expense.store}</td>
            <td>${expense.amount}</td>
            <td>{expense.purchaseDate}</td>
            <td>{expense.category}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}