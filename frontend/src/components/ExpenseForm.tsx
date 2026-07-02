"use client";

import { useState } from "react";
import { createExpense } from "@/services/expenseService";
import { useRouter } from "next/navigation";

export default function ExpenseForm() {

  const router = useRouter();

  const [store, setStore] = useState("");
  const [amount, setAmount] = useState("");
  const [purchaseDate, setPurchaseDate] = useState("");
  const [category, setCategory] = useState("");

  async function handleSubmit(
    e: React.FormEvent<HTMLFormElement>
  ) {
    e.preventDefault();

    try {
      await createExpense({
        store,
        amount: Number(amount),
        purchaseDate,
        category,
      });

      alert("¡Se ha creado un nuevo gasto!");

      setStore("");
      setAmount("");
      setPurchaseDate("");
      setCategory("");

      
      router.refresh();
      
    } catch (error) {
      console.error(error);
      alert("Ha ocurrido un error al crear el gasto.");
    }
  }

  return (
    <form
      onSubmit={handleSubmit}
      className="bg-gray-900 text-white p-6 rounded-xl shadow-md mb-8"
    >
      <h2 className="text-xl font-semibold mb-4">
        Nuevo Gasto
      </h2>

      <div className="grid grid-cols-2 gap-4">

        <input
          type="text"
          placeholder="Tienda"
          value={store}
          onChange={(e) => setStore(e.target.value)}
          className="border p-2 rounded"
          required
        />

        <input
          type="number"
          placeholder="Monto"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          className="border p-2 rounded"
          required
        />

        <input
          type="date"
          value={purchaseDate}
          onChange={(e) =>
            setPurchaseDate(e.target.value)
          }
          className="border p-2 rounded"
          required
        />

        <input
          type="text"
          placeholder="Categoría"
          value={category}
          onChange={(e) =>
            setCategory(e.target.value)
          }
          className="border p-2 rounded"
          required
        />

      </div>

      <button
        type="submit"
        className="mt-4 px-4 py-2 rounded bg-gray-400 text-white hover:bg-slate-50 hover:text-gray-700"
      >
        Crear
      </button>
    </form>
  );
}