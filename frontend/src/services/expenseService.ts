import { Expense } from "@/types/expense"; 

const API_URL = "http://localhost:8080/api/expenses"; 

export async function getExpenses(): Promise<Expense[]> {
    const response = await fetch(API_URL);
    if (!response.ok) {
        throw new Error("Failed to fetch expenses");
    }
    return response.json();
}