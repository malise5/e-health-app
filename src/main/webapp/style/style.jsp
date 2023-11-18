<style>
        /* General styles for the body */
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }

        /* Styles for the navigation bar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #3498db;
            padding: 10px 20px;
        }

        .logo img {
            height: 40px; /* Logo height */
        }

        /* Style the navigation links */
        .nav-links {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .nav-links li {
            display: inline;
            margin-right: 15px; /* Spacing between links */
        }

        .nav-links a {
            text-decoration: none;
            color: #fff; /* Link color */
            font-weight: bold;
        }

        .nav-links a:hover {
            color: #ff9900;
        }

        .nav-links a.active {
            color: #ff9900; /* Active link color */
        }

        /* Styles for the header section */
        header {
            background-color: #3498db;
            color: #fff;
            text-align: center;
            margin-top: 10px;
            padding: 5px 0;
        }

        h1 {
            font-size: 24px;
        }
        h1 {
            color: #ffff;
        }

        /* Styles for the container */
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* Styles for the table */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th,
        td {
            padding: 12px 15px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #e6e6e6;
        }

        /* Styles for the modal and form */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: auto;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.7);
        }

        .modal-content {
            background-color: #f4f4f4;
            margin: 2% auto 20% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }

        .close {
            position: absolute;
            right: 10px;
            top: 10px;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
        }

        /* Styles for the form inside the modal */
        form {
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }

        input {
            width: 90%;
            padding: 10px;
            margin: 5px 20px;
        }

        button {
            background-color: #0074cc;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .close:hover {
            color: red;
        }

         /* Add this CSS in your style/style.jsp or in a separate CSS file */
        .action-buttons {
            display: flex;
            justify-content: space-around;
        }

        .action-buttons button {
            padding: 8px 12px;
            margin: 4px;
            cursor: pointer;
        }

        .edit-button {
            background-color: #3498db;
            color: #fff;
            border: none;
        }

        .delete-button {
            background-color: #e74c3c;
            color: #fff;
            border: none;
        }

      </style>