import React, { useState, useEffect } from "react";
import Modal from "./components/Modal";
import axios from "axios";

export default function App() {
  const [viewCompleted, setViewCompleted] = useState(false);
  const [activeItem, setActiveItem] = useState({
    title: "",
    description: "",
    completed: false,
  });
  const [todoList, setTodoList] = useState([]);
  const [modal, setModal] = useState(false);

  function refreshList() {
    axios
      .get("/api/todo")
      .then((res) => setTodoList(res.data))
      .catch((err) => console.log(err));
  }
  useEffect(() => {
    refreshList();
  }, []);

  function renderTabList() {
    return (
      <div className="my-5 tab-list">
        <span
          onClick={() => setViewCompleted(true)}
          className={viewCompleted ? "active" : ""}
        >
          Complete
        </span>
        <span
          onClick={() => setViewCompleted(false)}
          className={viewCompleted ? "" : "active"}
        >
          Incomplete
        </span>
      </div>
    );
  }

  function handleSubmit(item) {
    setModal(!modal);
    if (item.id) {
      axios.put(`/api/todo/${item.id}`, item).then(() => refreshList());
      return;
    }
    axios.post("/api/todo", item).then(() => refreshList());
  }
  function handleDelete(item) {
    axios.delete(`/api/todo/${item.id}`).then(() => refreshList());
  }
  function createItem() {
    const item = { title: "", description: "", completed: false };
    setActiveItem(item);
    setModal(!modal);
  }
  function editItem(item) {
    setActiveItem(item);
    setModal(!modal);
  }

  function renderItems() {
    const newItems = todoList.filter((item) => item.completed === viewCompleted);
    return newItems.map((item) => (
      <li
        key={item.id}
        className="list-group-item d-flex justify-content-between align-items-center"
      >
        <span className={`todo-title mr-2 ${viewCompleted ? "completed-todo" : ""}`}>
          {item.title}
        </span>
        <span>
          <button onClick={() => editItem(item)} className="btn btn-secondary mr-2">
            {" "}
            Edit{" "}
          </button>
          <button onClick={() => handleDelete(item)} className="btn btn-danger">
            Delete{" "}
          </button>
        </span>
      </li>
    ));
  }
  return (
    <main className="content">
      <h1 className="text-white text-uppercase text-center my-4">Todo app</h1>
      <div className="row ">
        <div className="col-md-6 col-sm-10 mx-auto p-0">
          <div className="card p-3">
            <div className="">
              <button onClick={createItem} className="btn btn-primary">
                Add task
              </button>
            </div>
            {renderTabList()}
            <ul className="list-group list-group-flush">{renderItems()}</ul>
          </div>
        </div>
      </div>
      {modal ? (
        <Modal
          activeItem={activeItem}
          toggle={() => setModal(!modal)}
          onSave={handleSubmit}
        />
      ) : null}
    </main>
  );
}
