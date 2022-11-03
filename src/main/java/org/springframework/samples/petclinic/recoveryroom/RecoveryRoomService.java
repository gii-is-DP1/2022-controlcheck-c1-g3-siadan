package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecoveryRoomService {

    private RecoveryRoomRepository recoveryRoomRepository;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository r){
        this.recoveryRoomRepository = r;
    }

    public List<RecoveryRoom> getAll(){
        return this.recoveryRoomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return this.recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        List<RecoveryRoom> rrlist = this.recoveryRoomRepository.findAll();
        for(RecoveryRoom r : rrlist){
            if(p.getName().equals(r.getName())){
                throw new DuplicatedRoomNameException();
            }
        }      

        return this.recoveryRoomRepository.save(p);
    }

    
}
