import { getExpenses } from "@/services/expenseService";
import ExpenseTable from "@/components/ExpenseTable";

export default async function Home() {
  const expenses = await getExpenses();

  return (
    <main>
      <h1>Expense OCR</h1>

      <ExpenseTable expenses={expenses} />
    </main>
  );
}