import UserResponse from "../../../models/user/UserResponse";
import React from "react";
import { RouteComponentProps } from "react-router-dom";

interface UserIndexState {
  users: UserResponse[];
}

interface UserIndexResponseModel {
  users: UserResponse[];
}

export class UserIndex extends React.Component<RouteComponentProps<{}>, UserIndexState> {
  constructor(props: RouteComponentProps) {
    super(props);

    this.state = {
      users: []
    }

    this.load()
  }

  private load(): Promise<void> {
    return fetch('api/user')
        .then(res => res.json() as Promise<UserIndexResponseModel>)
        .then(data => this.setState({ users: data.users }))
  }

  public render(): JSX.Element {
    return (
        <div>
          <h1>User Index</h1>
        </div>
    )
  }
}