"use client";
import { Expense } from "@/types/expense";
import { deleteExpense } from "@/services/expenseService";
import { useRouter } from "next/navigation"
import Link from "next/link";

interface Props {
  expenses: Expense[];
}

export default function ExpenseTable({ expenses }: Props) {
  const router = useRouter();
  async function handleDelete(id: string){
    const confirmed = confirm(
      "¿Estás seguro de que deseas eliminar este gasto? Esta acción no se puede deshacer."
    );

    if(!confirmed) return; 

    try{
      await deleteExpense(id);

      router.refresh();
    } catch (error){
      console.error(error); 
      alert("Ocurrió un error al eliminar el gasto. Por favor, inténtalo de nuevo más tarde.");
    }
  }
  return (
    <div className="text-white rounded-xl shadow-md overflow-hidden">

      <table className="w-full">

        <thead className="bg-gray-900">
          <tr>
            <th className="text-left p-4">Tienda</th>
            <th className="text-left p-4">Monto</th>
            <th className="text-left p-4">Fecha</th>
            <th className="text-left p-4">Categoría</th>
            <th className="text-left p-4">Acciones</th>
          </tr>
        </thead>

        <tbody>
          {expenses.map((expense) => (
            <tr
              key={expense.id}
              className="bg-gray-400 border-t hover:bg-slate-50 hover:text-gray-700"
            >
              <td className="p-4">
                {expense.store}
              </td>

              <td className="p-4 font-semibold">
                {new Intl.NumberFormat("es-MX", {
                style: "currency",
                currency: "MXN",
                }).format(expense.amount)}
              </td>

              <td className="p-4">
                {expense.purchaseDate}
              </td>

              <td className="p-4">
                {expense.category}
              </td>

              <td>  
                <div className="flex gap-2">
                  <Link
                    href={`/expenses/${expense.id}`}
                    className="px-3 py-1 rounded bg-blue-600 text-white"
                  >
                    Edit
                  </Link>

                  <button 
                    onClick={() => handleDelete(expense.id)}
                    className="px-3 py-1 rounded bg-red-500 text-white"
                  >
                    Eliminar
                  </button>
                </div>
              </td>
            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}