import React, { useState } from "react";
import "./login.css";
import { TbEyeOff, TbEye } from "react-icons/tb";
import { Link } from "react-router-dom";

const Login = () => {
  const [form, setForm] = useState({});
  const [password, setPassword] = useState(false);
  const handlePassword = () => {
    setPassword(!password);
  };

  const handleFormData = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };
  const handleFormDataOnSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log(form);
  };

  return (
    <div className="parent-login-div">
      <div className="container">
        <div className="login-div">
          <div className="left-login-div">
            Don't have account?, <Link to="/register">Register here</Link>
          </div>
          <div className="right-login-div">
            <h1 className="sign-in-content align-center">LOGIN</h1>
            <h4 className="align-center mb-4">
              Please enter the below details
            </h4>
            <form className="form-container" onSubmit={handleFormDataOnSubmit}>
              <div className="mb-4">
                <input
                  type="email"
                  className="form-control"
                  name="email"
                  placeholder="Email"
                  onChange={handleFormData}
                />
              </div>
              <div className="mb-4">
                <div className="password-div">
                  <input
                    type={password ? "password" : "text"}
                    className="form-control"
                    name="password"
                    placeholder="Password"
                    onChange={handleFormData}
                    id="exampleInputPassword1"
                  />
                  {password ? (
                    <span onClick={handlePassword}>
                      <TbEyeOff />
                    </span>
                  ) : (
                    <span onClick={handlePassword}>
                      <TbEye />
                    </span>
                  )}
                </div>
              </div>
              <div className="remember-forgot-inputs mb-4">
                <div className="checkbox-input">
                  <input type="checkbox" id="remember-me" />
                  <label htmlFor="remember-me" className="px-2">
                    Remember Me
                  </label>
                </div>
                <div className="forgot-password">Forgot Password </div>
              </div>
              <Link type="submit" className="btn btn-primary" to="/homepage">
                Login
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Login;
