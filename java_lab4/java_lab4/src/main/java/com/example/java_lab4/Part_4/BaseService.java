package com.example.java_lab4.Part_4;

public class BaseService<TRepository extends BaseRepository> {
    private BaseRepository _productRepo;

    public  BaseService(TRepository userRepo) {
        _productRepo = userRepo;
    }

    public Product findById(int id){
        return _productRepo.findById(id);
    }

    public Iterable<Product> getAll(){
        return  _productRepo.findAll();
    }

    public int create(ProductDTO productDTO){
        try{
//            JMapper<User, UserDTO> mapper = new JMapper<User, UserDTO>(User.class, UserDTO.class);

//            User newUser = mapper.getDestination(userDto);
            Product newProduct = new Product();
            newProduct.setProductName(productDTO.getProductName());
            newProduct.setProductDescription(productDTO.getProductDescription());
            newProduct.setProductPrice(productDTO.getProductPrice());

            return _productRepo.add(newProduct);
        }catch(Exception e){
            return -1;
        }

    }

    public void update(ProductDTO productDTO, int id) throws Exception{{
    }
        Product toUpdate = _productRepo.findById(id);

        if(toUpdate == null){
            throw new Exception();
        }

//        JMapper<User, UserDTO> mapper = new JMapper<>(User.class, UserDTO.class);
//
//        User updatedUser = mapper.getDestination(toUpdate, userDTO);
        Product updatedProduct = new Product();
        updatedProduct.setProductName(productDTO.getProductName());
        updatedProduct.setProductDescription(productDTO.getProductDescription());
        updatedProduct.setProductPrice(productDTO.getProductPrice());

        var x =  _productRepo.deleteById(toUpdate);
        _productRepo.update(updatedProduct);


    }

    public boolean delete(int id){

        return _productRepo.deleteById(_productRepo.findById(id));
    }
}
