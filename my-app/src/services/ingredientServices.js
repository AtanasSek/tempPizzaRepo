export const getIngredients = ()=>{
    return ingredientList;
};

export const saveIngredient = (ingredient)=>{
    ingredientList.push(ingredient);
};

let ingredientList = [
    {
        name:"Chili pepper",
        amount:"20",
        isSpicy:true,
        isVeggie:true
    }
];