import { getExpenses } from "@/services/expenseService";
import ExpenseTable from "@/components/ExpenseTable";


export default async function Home() {
  const expenses = await getExpenses(); 

  if (expenses.length === 0) {
    return (
      <div className="bg-white rounded-xl shadow p-8 text-center">
        <p>No expenses registered yet.</p>
      </div>
    );
  }

  return (
    <main className="min-h-screen bg-gray-300">
      <div className="max-w-5xl mx-auto p-8">

        <div className="mb-8">


          <h1 className="text-4xl fond-bold text-gray-800">
            Expense OCR
          </h1>

          <p className="text-gray-600 mt-2">
            Manage your expenses and receipts.
          </p>

        </div> 

        <ExpenseTable expenses={expenses} />

      </div>
      
    </main>
  );
}