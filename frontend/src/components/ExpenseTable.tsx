import { Expense } from "@/types/expense";

interface Props {
  expenses: Expense[];
}

export default function ExpenseTable({ expenses }: Props) {
  return (
    <table border={5} cellPadding={15} cellSpacing={5} style={{ borderCollapse: 'separate' }}>
      <thead>
        <tr>
          <th style={{ padding: '15px 20px' }}>Store</th>
          <th style={{ padding: '15px 20px' }}>Amount</th>
          <th style={{ padding: '15px 20px' }}>Date</th>
          <th style={{ padding: '15px 20px' }}>Category</th>
        </tr>
      </thead>

      <tbody>
        {expenses.map((expense) => (
          <tr key={expense.id} style={{ marginBottom: '15px' }}>
            <td style={{ padding: '20px 25px' }}>{expense.store}</td>
            <td style={{ padding: '20px 25px' }}>${expense.amount}</td>
            <td style={{ padding: '20px 25px' }}>{expense.purchaseDate}</td>
            <td style={{ padding: '20px 25px' }}>{expense.category}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}