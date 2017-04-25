package home.core.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Классы, выведенные из этого и аннотированные как @Controller, добавляются в шапку. Путь для перехода берется из
 * @RequestMapping метода index.
 * @author d_sergeev
 */
public abstract class AbstractPageableController extends AbstractController {

	/**
	 * Имена переменных, в которых на страницу передаются списки сообщений
	 * об успешном совершении действий и об ошибках
	 */
	public enum MessagesType {
		INFO_MESSAGES,
		GLOBAL_ERRORS,
		FIELDS_ERRORS
	}

	@Autowired
	protected MessageSource messageSource;


	/**
	 * Добавление на страницу информационного сообщения об успешном совершении действия.
	 */
	@SuppressWarnings("unchecked")
	protected void addInfoMessage(RedirectAttributes redirectAttributes, String code, Locale locale) {
		List<String> messages = (List<String>)redirectAttributes.getFlashAttributes().get(MessagesType.INFO_MESSAGES.name());

		if (messages == null) {
			messages = new ArrayList<>();
			redirectAttributes.addFlashAttribute(MessagesType.INFO_MESSAGES.name(), messages);
		}

		messages.add(messageSource.getMessage(code, null, code, locale));
	}


	/**
	 * Добавление на страницу информационного сообщения о глобальной ошибке при совершении действия.
	 * Используется при отображении сообщения на той же странице, где произошла ошибка.
	 */
	@SuppressWarnings("unchecked")
	protected void addGlobalErrorMessage(ModelAndView modelAndView, String code, Locale locale) {
		List<String> messages = (List<String>)modelAndView.getModelMap().get(MessagesType.GLOBAL_ERRORS.name());

		if (messages == null) {
			messages = new ArrayList<>();
			modelAndView.addObject(MessagesType.GLOBAL_ERRORS.name(), messages);
		}

		messages.add(messageSource.getMessage(code, null, code, locale));
	}


	/**
	 * Добавление на страницу информационного сообщения о глобальной ошибке при совершении действия.
	 * Используется при отображении сообщения на другой странице, куда будет совершён redirect.
	 */
	@SuppressWarnings("unchecked")
	public void addGlobalErrorMessage(RedirectAttributes redirectAttributes, String code, Locale locale) {
		List<String> messages = (List<String>)redirectAttributes.getFlashAttributes().get(MessagesType.GLOBAL_ERRORS.name());

		if (messages == null) {
			messages = new ArrayList<>();
			redirectAttributes.addFlashAttribute(MessagesType.GLOBAL_ERRORS.name(), messages);
		}

		messages.add(messageSource.getMessage(code, null, code, locale));
	}


	/**
	 * Добавление на страницу информационного сообщения об ошибке в заполнении конкретного поля формы.
	 */
	@SuppressWarnings("unchecked")
	protected void addFieldErrorMessage(ModelAndView modelAndView, String fieldName, String code, Locale locale) {
		Map<String, String> errors = (Map<String, String>)modelAndView.getModelMap().get(MessagesType.FIELDS_ERRORS.name());

		if (errors == null) {
			errors = new HashMap<>();
			modelAndView.addObject(MessagesType.FIELDS_ERRORS.name(), errors);
		}

		errors.put(fieldName, messageSource.getMessage(code, null, code, locale));
	}


}