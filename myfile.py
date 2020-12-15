def save_index(self, storage_directory: str) -> None:
        """
        Save index to directory
        :param storage_directory: path to folder where index will be saved
        """
        os.makedirs(storage_directory, exist_ok=True)
        np.save(os.path.join(storage_directory, "index_data"), self.index_data)
        np.save(os.path.join(storage_directory, "index_pointers"), self.index_pointers)
        np.save(os.path.join(storage_directory, "token2id"), self.token2id)
        np.save(os.path.join(storage_directory, "index"), self.index)
        np.save(os.path.join(storage_directory, "token_index_size"), self.token_index_size)
        np.save(os.path.join(storage_directory, "entities_names"), self.entities_names)
        np.save(os.path.join(storage_directory, "token2int_value"), self.token2int_value)
