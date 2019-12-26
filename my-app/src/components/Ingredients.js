import * as React from "react";
import {getIngredients} from "../services/ingredientServices";
import {withRouter} from "react-router";

class Ingredients extends React.Component{

    renderIngredients = () =>{
        let ingredients = [];
        this.state.ingredients.forEach((x) => {
            let ingredient = (
                <tr>
                    <td scope="col">{x.name}</td>
                    <td scope="col">{x.amount}</td>
                    <td scope="col">{x.isSpicy + ""}</td>
                    <td scope="col">{x.isVeggie + ""}</td>
                    <td scope="col">
                        <button className="btn btn-sm btn-secondary">
                            <span className="fa fa-edit"/>
                            <span><strong>Edit</strong></span>
                        </button>
                        <button className="btn btn-sm btn-outline-secondary ">
                            <span className="fa fa-remove"/>
                            <span><strong>Remove</strong></span>
                        </button>
                        <button className="btn btn-sm btn-outline-dark">
                            <span><strong>Details</strong></span>
                        </button>
                    </td>
                </tr>
            );
            ingredients.push(ingredient);
        });

        return ingredients;
    };

    constructor(props){
        super(props);
        let ingredients = getIngredients();
        this.state = {
            ingredients:ingredients
        }
    }
    render() {
        return(
            <div className="container">
                <div className="row">
                    <h4 className="text-upper text-left">Ingredients</h4>
                    <div className="table-responsive">
                        <table className="table tr-history table-striped small">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Spicy</th>
                                <th scope="col">Veggie</th>
                                <th scope="col">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {this.renderIngredients()}
                            </tbody>
                        </table>
                    </div>
                    <button onClick={this.openForm} className="btn btn-outline-secondary">
                        <span><strong>Add new ingredient</strong></span>
                    </button>
                </div>
            </div>
        )
    }

    openForm = (event) => {
        event.preventDefault();
        this.props.history.push("/ingredients/new");
    }

}

export default withRouter(Ingredients);