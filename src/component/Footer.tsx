import React from "react";

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-logo-section">
          <img
            src="dummy-logo.png"
            alt="OnlineBookstore Logo"
            className="footer-logo"
          />
          <h3 className="footer-company-name">OnlineBookstore</h3>
        </div>

        <div className="footer-links">
          <a href="/about" className="footer-link">
            About Us
          </a>
          <a href="/careers" className="footer-link">
            Careers
          </a>
          <a href="/privacy-policy" className="footer-link">
            Privacy Policy
          </a>
          <a href="/terms-of-service" className="footer-link">
            Terms of Service
          </a>
        </div>

        <div className="footer-copyright">
          &copy; {new Date().getFullYear()} OnlineBookstore. All rights
          reserved.
        </div>
      </div>
    </footer>
  );
};

export default Footer;
