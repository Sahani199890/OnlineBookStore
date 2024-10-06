import { useState } from "react";
import "./login.css";
import { TbEyeOff, TbEye } from "react-icons/tb";
import { Link } from "react-router-dom";

type FormData = {
  email: string;
  password: string;
  confirmPassword: String;
};

const Register = () => {
  const [formData, setFormData] = useState<FormData>({
    email: "",
    password: "",
    confirmPassword: "",
  });

  const [password, setPassword] = useState(false);
  const [conPassword, setConPassword] = useState(false);

  const handleFormData = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };
  const handleFormDataOnSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log(formData);
  };
  const handlePassword = () => {
    setPassword(!password);
  };
  const handleConPassword = () => {
    setConPassword(!conPassword);
  };
  return (
    <div className="parent-login-div">
      <div className="container">
        <div className="login-div register-parent">
          <div className="left-login-div">
            Already have account?, <Link to="/login">Login here</Link>
          </div>
          <div className="right-login-div">
            <h1 className="sign-in-content align-center">REGISTER</h1>
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
              <div className="mb-4">
                <div className="password-div">
                  <input
                    type={conPassword ? "password" : "text"}
                    className="form-control"
                    name="confirmPassword"
                    placeholder="Confirm Password"
                    onChange={handleFormData}
                  />
                  {conPassword ? (
                    <span onClick={handleConPassword}>
                      <TbEyeOff />
                    </span>
                  ) : (
                    <span onClick={handleConPassword}>
                      <TbEye />
                    </span>
                  )}
                </div>
              </div>
              <button type="submit" className="btn btn-primary">
                Register
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Register;
