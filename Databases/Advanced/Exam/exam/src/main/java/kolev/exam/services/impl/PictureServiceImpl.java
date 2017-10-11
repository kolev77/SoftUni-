package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.entities.Picture;
import kolev.exam.repositories.PictureRepository;
import kolev.exam.services.api.PictureService;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String add(Picture picture) {
        String result;

        if (DataValidator.isValid(picture)) {
            this.pictureRepository.save(picture);
            result = String.format(ResultMessages.SUCCESSFUL,
                    picture.getClass().getSimpleName(),
                    picture);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }
}
