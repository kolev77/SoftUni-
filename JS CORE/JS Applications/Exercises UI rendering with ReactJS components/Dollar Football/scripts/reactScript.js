function solve() {
    class AppView extends React.Component {
        render() {
            return (
                <div className="wrapper">
                <HeaderView/>
                <ButtonHolder/>
                </div>
            )
        }
    }


    class HeaderView extends React.Component {
        render() {
            return (
                <header>
                    Dollar Football
                </header>
            )
        };
    }

    class ButtonHolder extends React.Component {
        render() {
            <div className="button-holder">
                <button id="bets" class="button">My Bets</button>
                <button id="matches" class="button">Matches</button>
            </div>
        }
    }

    class ContentHolder extends React.Component{
        render() {
            return (
                <div className="content-holder">
                </div>
            )
        }
    }
    return {
        AppView,
        HeaderView,
        ButtonHolder,
        ContentHolder
    }
}

let components = solve();

ReactDOM.render(
    components.AppView,
    $("#app")[0]
);