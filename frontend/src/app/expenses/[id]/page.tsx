import ExpenseForm from "@/components/ExpenseForm";
import { getExpenseById } from "@/services/expenseService";

export default async function EditExpensePage({params,}: {params: Promise<{ id: string }>;}){
    const { id } = await params;
  
    const expense = await getExpenseById(id);
  
    return (
      <main className="min-h-screen bg-slate-100 p-8">
  
        <div className="max-w-2xl mx-auto">
  
          <h1 className="text-3xl font-bold mb-6">
            Edit Expense
          </h1>
  
          <ExpenseForm
            initialData={expense}
          />
  
        </div>
  
      </main>
    );
  }
  