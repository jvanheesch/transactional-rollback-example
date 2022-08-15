package io.github.jvanheesch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ApplicationTest {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    NoteService noteService;

    @Test
    void testChecked() {
        Note note = new Note();
        note.setId(1L);

        assertThatThrownBy(() -> noteService.saveCheckedException(note))
                .isNotInstanceOf(RuntimeException.class);

        assertThat(noteRepository.findById(1L))
                .isNotEmpty();
    }

    @Test
    void testUnchecked() {
        Note note = new Note();
        note.setId(2L);

        assertThatThrownBy(() -> noteService.saveUncheckedException(note))
                .isInstanceOf(RuntimeException.class);

        assertThat(noteRepository.findById(2L))
                .isEmpty();
    }
}
