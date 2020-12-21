import React from "react";
import {NavAppBar} from "./NavAppBar";
import {Container} from "@material-ui/core";

export interface LayoutProps {
  children?: React.ReactNode
}

export class Layout extends React.Component<LayoutProps, {}> {
  public render() {
    return (
        <div>
          <NavAppBar />
          <Container>
            {this.props.children ?? <React.Fragment/>}
          </Container>
        </div>
    )
  }
}