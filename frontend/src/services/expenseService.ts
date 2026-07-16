import { Expense } from "@/types/expense"; 

const API_URL = "http://localhost:8080/api/expenses"; 

export async function getExpenses(): Promise<Expense[]> {
    const response = await fetch(API_URL);
    if (!response.ok) {
        throw new Error("Failed to fetch expenses");
    }
    return response.json();
}

export async function createExpense(data:  {
    store: string;
    amount: number;
    purchaseDate: string;
    category: string;
}){
    const response = await fetch(API_URL, {
        method: "POST", 
        headers: {
            "Content-Type": "application/json",
        }, 
        body: JSON.stringify(data),
    }); 

    if (!response.ok) {
        throw new Error("Failed to create expense");
    }
    
    return response.json();
}

export async function deleteExpense(id: string): Promise<void> {
    const response = await fetch(
        `http://localhost:8080/api/expenses/${id}`, 
        {
            method: "DELETE",
        }
    );

    if(!response.ok) {
        throw new Error("Surgió un error al eliminar el gasto.");
    }
}

export async function updateExpense(
    id: string,
    data: {
        store: string; 
        amount: number; 
        purchaseDate: string; 
        category: string; 
    }
){ 
    const response = await fetch('http://localhost:8080/api/expenses/${id}',
        { 
            method: "PUT", 
            headers: {
                "content-Type": "aplication/json",
            }, 
            body: JSON.stringify(data),
        }
    ); 

    if(!response.ok) {
        throw new Error("Surgió un error al actualizar el gasto.");
    }

    return response.json();
}

export async function getExpenseById(id: string,){ 
    const response = await fetch('http://localhost:8080/api/expenses/${id}'); 

    if(!response.ok) {
        throw new Error("No existe el gasto.");
    }

    return response.json();
}