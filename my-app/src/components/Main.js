import * as React from "react";
import Menu from "./Menu";
import {Route, BrowserRouter as Router, Switch} from "react-router-dom";
import {Link} from "react-router-dom";
import Pizzas from "./Pizzas";
import Ingredients from "./Ingredients";
import Home from "./Home";
import AddIngredient from "./AddIngredient";

class Main extends React.Component {
    render() {
        return (
            <div>
                <Router>
                    <Menu/>
                    <Switch>
                        <Route path="/pizzas">
                            <Pizzas/>
                        </Route>
                        <Route exact path="/ingredients">
                            <Ingredients/>
                        </Route>
                        <Route path="/ingredients/new">
                            <AddIngredient/>
                        </Route>
                        <Route path="/">
                            <Home/>
                        </Route>
                    </Switch>
                </Router>
            </div>
        )
    }
}

export default Main;