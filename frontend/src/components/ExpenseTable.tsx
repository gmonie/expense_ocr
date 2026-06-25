"use client";
import { Expense } from "@/types/expense";

interface Props {
  expenses: Expense[];
}

export default function ExpenseTable({ expenses }: Props) {
  return (
    <div className="text-white rounded-xl shadow-md overflow-hidden">

      <table className="w-full">

        <thead className="bg-gray-900">
          <tr>
            <th className="text-left p-4">Tienda</th>
            <th className="text-left p-4">Monto</th>
            <th className="text-left p-4">Fecha</th>
            <th className="text-left p-4">Categoría</th>
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
            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}