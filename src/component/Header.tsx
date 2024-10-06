import { useState, useEffect } from "react";
import "./Header.css";
import { FaRegUser, FaOpencart, FaBell } from "react-icons/fa";
import { LuShoppingBag } from "react-icons/lu";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { SEARCH_DATA } from "../store/books/ActionType";
import { convertToBase64 } from "../helper/Misc";

const Header = () => {
  const dispatch = useDispatch();
  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    const delayDebounceFn = setTimeout(() => {
      if (searchTerm) {
        dispatch({ type: SEARCH_DATA, payload: convertToBase64(searchTerm) });
      }
    }, 1000);

    return () => clearTimeout(delayDebounceFn);
  }, [searchTerm, dispatch]);

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(e.target.value);
  };

  return (
    <div className="header">
      <div className="container-overflow">
        <div className="header-div">
          <div className="logo">
            <Link to="/">
              <img src="/logo.png" alt="Book Haven Logo" />
            </Link>
          </div>
          <div className="list-div">
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/books">Books</Link>
              </li>
              <li>
                <Link to="/categories">Categories</Link>
              </li>
              <li>
                <Link to="/offers">Deals</Link>
              </li>
              <li>
                <Link to="/contact">Contact</Link>
              </li>
            </ul>
          </div>

          <div className="search-bar">
            <div className="search-bar-div">
              <input
                onChange={handleSearchChange}
                className="form-control"
                placeholder="Search books, authors, ISBN"
                type="search"
                value={searchTerm}
                aria-label="Search books"
              />
            </div>
          </div>
          <div className="icons-div">
            <div className="notification-icon">
              <FaBell />
              <span className="notification-count counter-div">5</span>
            </div>

            <div className="profile-icon">
              <FaRegUser />
              <div className="profile-div">
                <div className="profile">
                  <img src="/profile-pic.jpg" alt="Profile" />
                  Abhishek Sahani
                </div>
                <div className="profile-dropdown">
                  <Link to="/profile">Profile</Link>
                  <Link to="/orders">Orders</Link>
                  <Link to="/settings">Settings</Link>
                  <div className="logout">Logout</div>
                </div>
              </div>
            </div>
            <div className="wishlist in-icons">
              <LuShoppingBag />
              <span className="wishlist-count counter-div">2</span>
            </div>
            <div className="cart in-icons">
              <FaOpencart />
              <span className="cart-count counter-div">3</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;
