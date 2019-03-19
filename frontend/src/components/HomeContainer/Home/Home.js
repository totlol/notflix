import {PreviewRow} from "../../PreviewRow/PreviewRow";
import {Preview} from "../../Preview/Preview";
import Block from "../../Block/Block";
import React, {Component} from "react";
import Header from "../../Header/Header";
import {BrowserRouter as Router} from "react-router-dom";

class Home extends Component {

    render() {
        const titles = this.props.titles || [];
        return (
            <React.Fragment>
                <Header/>
                <Block vertical>
                    <PreviewRow title="All movies">
                        {
                            titles.map(title => (
                                <Preview title={title}/>
                            ))
                        }
                    </PreviewRow>
                </Block>
            </React.Fragment>
        );
    }
}


export default Home;